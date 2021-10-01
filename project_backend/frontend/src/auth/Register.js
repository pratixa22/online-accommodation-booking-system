import React, { useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";
import constants from "./constants";

const Register = ({ history }) => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNo, setPhoneNo] = useState("");
  const [dob, setDob] = useState("");
  const [password, setPassword] = useState("");
  const [idProof, SetIdProof] = useState("");

  //console.log("history",history);

  const handleSubmit = async (e) => {
    const url = constants.server + "/register";
    e.preventDefault();
    try {
      await axios.post(url, {
        firstName,
        lastName,
        email,
        phoneNo,
        dob,
        password,
        idProof,
      });

      toast.success("resgister done");
      history.push("/login");
    } catch (err) {
      console.log(err);
      if (err.response.status === 400) toast(err.response.data);
    }
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
            type="email"
            className="form-control"
            placeholder="Enter email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Password</label>
        <div className="col-sm-9">
          <input
            type="password"
            className="form-control"
            placeholder="Enter password"
            autoComplete="username"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </div>
      </div>

      <div className="mb-3 row">
        <label className="col-sm-3 col-form-label">Aadhaar no.</label>
        <div className="col-sm-9">
          <input
            type="text"
            className="form-control"
            placeholder="Aadhaar no."
            value={idProof}
            onChange={(e) => SetIdProof(e.target.value)}
          />
        </div>
      </div>
      <div className="d-grid gap-2 d-md-flex justify-content-md-center">
        <button
          disabled={
            !firstName ||
            !lastName ||
            !phoneNo ||
            !dob ||
            !email ||
            !password ||
            !idProof
          }
          className="btn btn-primary"
        >
          Submit
        </button>
      </div>
    </form>
  );

  return (
    <>
      <div className="container-fluid bg-light p-1 text-center">
        <h1>Register</h1>
      </div>

      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3">{registerForm()}</div>
        </div>
      </div>
    </>
  );
};

export default Register;
