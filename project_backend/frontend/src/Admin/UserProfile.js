import React, { useEffect, useState } from "react";

import axios from "axios";

import DashboardNav from "../components/DashboardNav";
import constants from "../auth/constants";

const UserProfile = ({ match }) => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [dob, setDob] = useState("");
  const [idProof, SetIdProof] = useState("");
  const url = constants.server;
  useEffect(() => {
    console.log(match.params.id);
    const getUser = () => {
      axios
        .get(url + `/user/${match.params.id}`)
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
  }, [match.params.id, url]);

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
              <span className="effect m-2 p-2"></span>
            </div>
            <div class="page-content page-container" id="page-content">
              <div class="padding">
                <div class="row container d-flex justify-content-center">
                  <div class="col-xl-6 col-md-12">
                    <div class="card user-card-full">
                      <div class="row m-l-0 m-r-0">
                        <div class="col-sm-4 bg-c-lite-green user-profile">
                          <div class="card-block text-center text-white">
                            <div class="m-b-25">
                              <img
                                src="https://img.icons8.com/bubbles/100/000000/user.png"
                                class="img-radius"
                                alt="pic"
                              />
                            </div>
                            <h6 class="f-w-600">
                              {firstName} {lastName}
                            </h6>
                          </div>
                        </div>
                        <div class="col-sm-8">
                          <div class="card-block">
                            <h6 class="m-b-20 p-b-5 b-b-default f-w-600">
                              Information
                            </h6>
                            <div class="row">
                              <div class="col-sm-6">
                                <p class="m-b-10 f-w-600">Email</p>
                                <h6 class="text-muted f-w-400">{email}</h6>
                              </div>
                              <div class="col-sm-6">
                                <p class="m-b-10 f-w-600">Phone</p>
                                <h6 class="text-muted f-w-400">{phoneNo}</h6>
                              </div>
                            </div>
                            <br />
                            <div class="row">
                              <div class="col-sm-6">
                                <p class="m-b-10 f-w-600">DOB</p>
                                <h6 class="text-muted f-w-400">{dob}</h6>
                              </div>
                              <div class="col-sm-6">
                                <p class="m-b-10 f-w-600"> Aadhar Card No</p>
                                <h6 class="text-muted f-w-400">{idProof}</h6>
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

export default UserProfile;
