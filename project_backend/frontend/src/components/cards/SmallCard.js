import { useSelector } from "react-redux";
import { useHistory, Link } from "react-router-dom";
import { toast } from "react-toastify";
import { EditOutlined, DeleteOutlined } from "@ant-design/icons";
import "./SmallCard.css";
import { useState } from "react";
import axios from "axios";
import constants from "../../auth/constants";

const SmallCard = ({
  h,
  // handleHotelDelete = (f) => f,
  host = false,
  showViewMoreButton = true,
  payment,
  orderCancel,
  review,
}) => {
  const { auth } = useSelector((state) => ({ ...state }));
  //const id = auth.id;
  const active = window.location.pathname;

  const [loading, setLoading] = useState(false);

  const url = constants.server;

  const history = useHistory();
  const handleClick = (e) => {
    e.preventDefault();
    // console.log(loading);
    if (!auth) {
      history.push("/login");
      return;
    }

    setLoading(true);

    if (auth) history.push(`/list/${h.id}`);
    console.log(loading);
  };

  const handleDelete = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.delete(url + `/acc/delete/${h.id}`);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 1000);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  const handleDeleteOrder = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.delete(url + `/order/delete/${h.id}`);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 1);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <>
      <div className="card mb-3">
        <div className="row no-gutters">
          <div className="col-md-4">
            {h.thumbnail ? (
              <img
                src={url + "/" + h.thumbnail}
                alt="pic"
                className="imag-sm{
                  border-radius: 5px;
                } card-image img img-fluid"
              />
            ) : (
              <img
                src="https://via.placeholder.com/900x500.png?text=MERN+Booking"
                alt="pic"
                className="card-image img img-fluid"
              />
            )}
          </div>
          <div className="col-md-8 ">
            <div className="card-body ">
              <h3 className="card-title">{h.title} </h3>
              <p className="alert alert-info col-md-3 text-center fw-bold fs-6">
                {h.location}
              </p>

              <p className="card-text h6 mb-3">{h.description}</p>
              <div className="row no-gutters ">
                <div className="col-md-6">
                  <p className="card-text mb-3 h6">{h.guest} bed</p>
                  <p className="card-text mb-3 h6 ">
                    Type of Accommodation : {h.type}{" "}
                  </p>
                  {/* <p className="card-text">
                                        Available from {new Date(h.from).toLocaleDateString()}
                                    </p> */}
                </div>
                <div className="col-md-4 ">
                  <p className="card-text h6">Price : {h.price}</p>
                  {/* <p className="card-text">
                                        Available from {new Date(h.from).toLocaleDateString()}
                                    </p> */}
                </div>
              </div>
              {/* <br /> */}
              <div className="d-flex justify-content-between h4">
                {showViewMoreButton && (
                  <button
                    onClick={handleClick}
                    className="btn btn-primary m-1 "
                  >
                    {loading
                      ? "Loading..."
                      : // : alreadyBooked
                      // ? "Already Booked"
                      auth
                      ? "Show more"
                      : "Login to View"}
                  </button>
                )}

                {payment && (
                  <button
                    onClick={() => history.push(`/list/book/${h.id}`)}
                    className="btn btn-success m-1 "
                  >
                    Payment
                  </button>
                )}

                {orderCancel && (
                  <button
                    onClick={handleDeleteOrder}
                    className="btn btn-danger m-1 "
                  >
                    Cancel Order
                  </button>
                )}

                {review && (
                  <button
                    onClick={() => history.push(`/review/add/${h.accoId}`)}
                    className="btn btn-primary m-1 "
                  >
                    Add review
                  </button>
                )}

                {active === "/dashboard/host" && (
                  <>
                    <Link to={`/list/edit/${h.id}`}>
                      <EditOutlined className="text-warning" />
                    </Link>
                    <DeleteOutlined
                      onClick={handleDelete}
                      className="text-danger marg-left"
                    />
                  </>
                )}
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default SmallCard;
