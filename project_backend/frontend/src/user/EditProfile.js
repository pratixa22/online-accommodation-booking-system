import React, { useEffect, useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";
import { useSelector } from "react-redux";
import constants from "../auth/constants";

const EditProfile = ({ history }) => {
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

  //console.log("history",history);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const res = await axios.put(url + "/update", {
        id: auth.id,
        firstName,
        lastName,
        email,
        phoneNo,
        dob,
        idProof,
      });
      if (res.data) {
        history.push("/dashboard");
      }
      toast.success(res.data);
    } catch {}
  };

  const registerForm = () => (
    <form onSubmit={handleSubmit} className="mt-3">
      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">First name</label>
        <div className="col-sm-9">
          <input
            type="text"
            className="form-control"
            placeholder="First name"
            value={firstName}
            onChange={(e) => setFirstName(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Last name</label>
        <div className="col-sm-9">
          <input
            type="text"
            className="form-control"
            placeholder="Last name"
            value={lastName}
            onChange={(e) => setLastName(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Phone Number</label>
        <div className="col-sm-9">
          <input
            type="number"
            className="form-control"
            placeholder="Phone Number"
            value={phoneNo}
            onChange={(e) => setPhoneNo(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Date of Birth</label>
        <div className="col-sm-9">
          <input
            type="date"
            className="form-control"
            placeholder="Date of Birth"
            value={dob}
            onChange={(e) => setDob(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Email Address</label>
        <div className="col-sm-9">
          <input
            readOnly
            type="email"
            className="form-control"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Id proof</label>
        <div className="col-sm-9">
          <input
            type="text"
            className="form-control"
            placeholder="Id proof"
            value={idProof || ""}
            onChange={(e) => SetIdProof(e.target.value)}
          />
        </div>
      </div>

      <button
        disabled={
          !firstName || !lastName || !phoneNo || !dob || !email || !idProof
        }
        className="btn btn-primary"
      >
        Submit
      </button>
    </form>
  );

  return (
    <>
      <div className="container-fluid bg-light p-1 text-center">
        <h1>Edit Profile</h1>
      </div>

      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3">{registerForm()}</div>
        </div>
      </div>
    </>
  );
};

export default EditProfile;
