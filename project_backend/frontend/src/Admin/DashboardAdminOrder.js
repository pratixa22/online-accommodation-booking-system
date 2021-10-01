import { useEffect, useState } from "react";
import axios from "axios";
import DashboardNav from "../components/DashboardNav";
import OrderRow from "./components/OrderRow";
import constants from "../auth/constants";

const DashboardAdminOrder = () => {
  const [orders, setOrders] = useState([]);
  const url = constants.server;
  useEffect(() => {
    const loadorders = async () => {
      let res = await axios.get(url + "/order/orderAll");
      setOrders(res.data.data);
    };
    loadorders();
  }, [url]);

  return (
    <>
      <div className="container-fluid bg-light p-1">
        <div className="d-flex justify-content-around h1">Admin Portal</div>
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

export default DashboardAdminOrder;
