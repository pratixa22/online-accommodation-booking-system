import React, { useState, useEffect } from "react";
import axios from "axios";
import { Select } from "antd";
import { toast } from "react-toastify";
import moment from "moment";

import { useSelector } from "react-redux";
import constants from "../auth/constants";

const PayHotel = ({ match, history }) => {
  const [amount, setAmount] = useState(0);
  const [payMethod, setPayMethod] = useState("");
  const [list, setList] = useState({});
  const [loading, setLoading] = useState(false);

  const { Option } = Select;
  const { auth } = useSelector((state) => ({ ...state }));

  const url = constants.server;

  useEffect(() => {
    const loadList = async () => {
      const url = constants.server + `/order/orderId/${match.params.id}`;
      let res = await axios.get(url);
      setList(res.data.data);
    };
    loadList();
  }, [match.params.id]);

  useEffect(() => {
    var checkInDate = moment(list.checkInDate);

    var checkOutDate = moment(list.checkOutDate);
    var diff = checkOutDate.diff(checkInDate);
    var diffDuration = moment.duration(diff);

    setAmount(diffDuration.days() * list.price || 0);
  }, [list.checkInDate, list.checkOutDate, list.price, amount]);

  const handleClick = async (e) => {
    e.preventDefault();
    if (!auth) {
      history.push("/login");
      return;
    }
    setLoading(true);
    if (!auth) history.push("/login");

    try {
      const res = await axios.post("http://localhost:8080/payment/new", {
        payMethod,
        paymentAmount: amount,
        order_id: list.id,
      });
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 1000);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <div>
      <div className="container-fluid bg-light p-2 text-center">
        <h1>{list.title}</h1>
      </div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-6">
            <br />

            <img
              src={url + "/" + list.thumbnail}
              alt=""
              className="card-image img img-fluid"
            />
          </div>

          <div className="col-md-6">
            <br />
            <b>{list.description}</b>
            <p className="alert alert-info mt-3">₹ {list.price}</p>
            <p className="card-text">No. of beds: {list.guest}</p>
            <p> Location :{list.location}</p>
            <p className="card-text">Check In Date: {list.checkInDate}</p>
            <p className="card-text">Check Out Date: {list.checkOutDate}</p>
            <i>
              Booked by {list.firstName} {list.lastName}
            </i>

            <br />

            <form className="mt-3">
              <Select
                onChange={(value) => setPayMethod(value)}
                className="w-100 m-2"
                size="large"
                name="title"
                placeholder="Mode of Payment"
              >
                <Option key={"UPI"}>{"UPI"}</Option>
                <Option key={"Card"}>{"Card"}</Option>
                <Option key={"Net Banking"}>{"Net Banking"}</Option>
              </Select>
              <label className=" btn-block m-2"> Total Amount</label>
              <input
                type="number"
                name="title"
                onChange={(e) => setAmount(e.target.value)}
                placeholder="Amount"
                className="form-control m-2"
                value={amount}
              />

              <button
                onClick={handleClick}
                className="btn btn-block btn-lg btn-primary mt-3"
                disabled={loading || list.paymentStatus}
              >
                {loading
                  ? "Loading..."
                  : auth && !list.paymentStatus
                  ? "Make Payment"
                  : "Payment Done"}
              </button>
            </form>
          </div>
        </div>
      </div>
      <br />
      <br />
      <br />
      {/* <pre>{JSON.stringify(list, null, 4)}</pre> */}
    </div>
  );
};

export default PayHotel;
