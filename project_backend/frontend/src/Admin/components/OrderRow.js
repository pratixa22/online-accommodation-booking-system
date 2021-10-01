import React from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import { toast } from "react-toastify";
import constants from "../../auth/constants";

const OrderRow = ({ order }) => {
  const url = constants.server;
  const history = useHistory();

  const myFunction = (e) => {
    e.preventDefault();
    history.push(`/list/${order.accoId}`);
    // <Link to={`/list/${order.accoId}`}></Link>;
  };
  const userFunction = (e) => {
    e.preventDefault();
    history.push(`/admin/user/profile/${order.userId}`);
    // <Link to={`/list/${order.accoId}`}></Link>;
  };

  const handleApproval = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.put(url + `/order/bookconfirm/${order.id}`);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 10);
    } catch (err) {
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <tr>
      <td>{order.id}</td>
      <td>{order.created_timestamp}</td>
      <td>{order.checkInDate}</td>
      <td>{order.checkOutDate}</td>
      <td> {JSON.stringify(order.paymentStatus)}</td>
      <td>{order.orderAmount}</td>
      <td>
        <button onClick={myFunction}>{order.accoId}</button>
      </td>

      <td>
        <button onClick={userFunction}>{order.userId}</button>
      </td>

      <td>
        <button
          onClick={handleApproval}
          className="btn btn-success btn-sm"
          disabled={order.hostStatus}
        >
          Approve
        </button>
        {/* <pre>{JSON.stringify(order, null, 4)}</pre> */}
      </td>
    </tr>
  );
};

export default OrderRow;
