import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { useSelector } from "react-redux";
import "./DashboardProfile.css";
import DashboardNav from "../components/DashboardNav";
import constants from "../auth/constants";

const Dashboard = () => {
  const { auth } = useSelector((state) => ({ ...state }));
  const id = auth.id;
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [dob, setDob] = useState("");
  const [idProof, SetIdProof] = useState("");
  const url = constants.server;
  useEffect(() => {
    const getUser = () => {
      axios
        .get(url + `/user/${id}`)
        .then((res) => {
          setFirstName(res.data.firstName);
          setLastName(res.data.lastName);
          setEmail(res.data.email);
          setPhoneNo(res.data.phoneNo);
          setDob(res.data.dob);
          SetIdProof(res.data.idProof);
        })
        .catch((err) => {});
    };
    getUser();
  }, [id, url]);

  return (
    <>
      <div className="container-fluid bg-light p-4">{/* <ConnectNav /> */}</div>
      <div className="container-fluid p-4">
        <DashboardNav />
      </div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-12">
            <div className="col-md-6 m-b-10 f-w-600">
              <span className="effect m-2 p-2">
                <Link className="btn" to="/profile">
                  Edit Profile
                </Link>
              </span>
              <span className="effect p-2">
                <Link className="btn " to="/changepw">
                  Change Password
                </Link>
              </span>
            </div>
            <div className="page-content page-container" id="page-content">
              <div className="padding">
                <div className="row container d-flex justify-content-center">
                  <div className="col-xl-6 col-md-12">
                    <div className="card user-card-full">
                      <div className="row m-l-0 m-r-0">
                        <div className="col-sm-4 bg-c-lite-green user-profile">
                          <div className="card-block text-center text-white">
                            <div className="m-b-25">
                              {" "}
                              <img
                                src="https://img.icons8.com/bubbles/100/000000/user.png"
                                className="img-radius"
                                alt="pic"
                              />{" "}
                            </div>
                            <h6 className="f-w-600">
                              {firstName} {lastName}
                            </h6>
                          </div>
                        </div>
                        <div className="col-sm-8">
                          <div className="card-block">
                            <h6 className="m-b-20 p-b-5 b-b-default f-w-600">
                              Information
                            </h6>
                            <div className="row">
                              <div className="col-sm-6">
                                <p className="m-b-10 f-w-600">Email</p>
                                <h6 className="text-muted f-w-400">{email}</h6>
                              </div>
                              <div className="col-sm-6">
                                <p className="m-b-10 f-w-600">Phone</p>
                                <h6 className="text-muted f-w-400">
                                  {phoneNo}
                                </h6>
                              </div>
                            </div>
                            <br />
                            <div className="row">
                              <div className="col-sm-6">
                                <p className="m-b-10 f-w-600">DOB</p>
                                <h6 className="text-muted f-w-400">{dob}</h6>
                              </div>
                              <div className="col-sm-6">
                                <p className="m-b-10 f-w-600">
                                  {" "}
                                  Aadhar Card No
                                </p>
                                <h6 className="text-muted f-w-400">
                                  {idProof}
                                </h6>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Dashboard;
