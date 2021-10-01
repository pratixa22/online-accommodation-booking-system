import { useEffect, useState } from "react";

import axios from "axios";

import { useSelector } from "react-redux";
import OrderRow from "../Admin/components/OrderRow";
import DashboardNav from "../components/DashboardNav";
import constants from "../auth/constants";

const DashboardHostOrder = () => {
  const { auth } = useSelector((state) => ({ ...state }));
  const id = auth.id;

  const [orders, setOrders] = useState([]);

  useEffect(() => {
    const url = constants.server + `/order/host/${id}`;
    const loadorders = async () => {
      let res = await axios.get(url);
      setOrders(res.data.data);
    };
    loadorders();
  }, [id]);

  return (
    <>
      <div className="container-fluid bg-light p-1">
        <div className="d-flex justify-content-around h1">Host Portal</div>
      </div>
      <div className="container-fluid p-1">
        <DashboardNav />
      </div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-10">
            <br />
          </div>
          <div className="col-md-2">
            {/* <button className=" nav-link btn btn-light">All Orders</button> */}
          </div>
        </div>
        <div className="container">
          <table className="table table-striped text-center">
            <thead>
              <tr>
                <th>Id</th>
                <th>Order Date</th>
                <th>Check In Date</th>
                <th>Check Out Date</th>
                <th>Payment Status</th>
                <th>Order Amount</th>
                <th>Accomodation Id</th>
                <th>User</th>
                <th>Actions</th>
              </tr>
            </thead>
            <tbody>
              {orders.map((order, k) => {
                return <OrderRow key={k} order={order} />;
              })}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default DashboardHostOrder;
