import React, { useState, useEffect } from "react";
import axios from "axios";
import { DatePicker } from "antd";
import { toast } from "react-toastify";
import moment from "moment";

import { useSelector } from "react-redux";
import Review from "../components/Review";
import constants from "../auth/constants";

const ViewHotel = ({ match, history }) => {
  const [list, setList] = useState({});
  const [loading, setLoading] = useState(false);
  // const [dates, setDates] = useState({});
  const [values, setValues] = useState({
    from: "",
    to: "",
  });
  const url = constants.server;
  const { auth } = useSelector((state) => ({ ...state }));
  const id = auth.id;
  const hid = match.params.id;
  // const active = window.location.pathname;

  // useEffect(() => {
  //   const loadorder = async () => {
  //     let res = await axios.get(url + `/order/acc/12`);
  //     setDates(res.data.data);
  //   };
  //   loadorder();
  // }, [url]);

  useEffect(() => {
    const loadList = async () => {
      let res = await axios.get(url + `/acc/accId/${match.params.id}`);
      setList(res.data.data);
    };
    loadList();
  }, [match.params.id, url]);

  const { from, to } = values;
  const handleClick = async (e) => {
    e.preventDefault();
    if (!auth) {
      history.push("/login");
      return;
    }
    setLoading(true);
    if (!auth) history.push("/login");

    try {
      const res = await axios.post(url + "/order/new", {
        userId: id,
        checkInDate: from,
        checkOutDate: to,
        accoId: match.params.id,
      });
      toast.success(res.data);
      history.push("/dashboard/book");
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <div>
      {/* <pre>{JSON.stringify(list, null, 4)}</pre> */}
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
            <i>Posted by {list.firstName}</i>
            <br />

            <form className="mt-3">
              <DatePicker
                placeholder="From date"
                className="form-control m-2"
                onChange={(date, dateString) =>
                  setValues({ ...values, from: dateString })
                }
                disabledDate={(current) =>
                  current && current.valueOf() < moment().subtract(1, "days")
                }
              />

              <DatePicker
                placeholder="To date"
                className="form-control m-2"
                onChange={(date, dateString) =>
                  setValues({ ...values, to: dateString })
                }
                disabledDate={(current) =>
                  current && current.valueOf() < moment().subtract(1, "days")
                }
              />

              <div className="row">
                <span>
                  <button
                    onClick={handleClick}
                    className="btn btn-block btn-lg btn-primary mt-3"
                    disabled={loading || !to || !from}
                  >
                    {loading
                      ? "Loading..."
                      : auth && auth.id
                      ? "Book Now"
                      : "Login to Book"}
                  </button>
                </span>
              </div>
            </form>
          </div>

          <div className="row">
            <div className="col-md-6">
              <br />
              <Review key={hid} hid={hid} />
            </div>
            <div className="col-md-6">
              <br />
              <br />
              <div className="">
                <table className="table table">
                  <thead>
                    <tr>
                      <th>Address</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        {list.addressLine1}, {list.addressLine2}
                      </td>
                    </tr>
                    <tr>
                      <td>
                        {list.city} {list.state} - {list.pincode}
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
      <br />
      <br />
      <br />
      <pre>{JSON.stringify(list, null, 4)}</pre>
      {/* <pre>{JSON.stringify(dates, null, 4)}</pre> */}
    </div>
  );
};

export default ViewHotel;
