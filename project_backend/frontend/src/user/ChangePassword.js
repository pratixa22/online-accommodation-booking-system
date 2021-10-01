import React from "react";
import { useState } from "react";
import { toast } from "react-toastify";
import { useSelector } from "react-redux";
import axios from "axios";
import constants from "../auth/constants";

const ChangePassword = ({ history }) => {
  const { auth } = useSelector((state) => ({ ...state }));
  const [oldPassword, setOldPassword] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const url = constants.server;
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.put(url + "/changepw", {
        id: auth.id,
        oldPassword,
        newPassword,
      });
      toast.success("password changed");

      history.push("/dashboard");
    } catch (err) {
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };
  return (
    <>
      <div className="container-fluid bg-light p-1 text-center">
        <h1>Change Password</h1>
      </div>

      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3">
            <form onSubmit={handleSubmit} className="mt-3">
              <div className="form-group mb-3">
                <label className="form-label">Old Password</label>
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter password"
                  autoComplete="username"
                  value={oldPassword}
                  onChange={(e) => setOldPassword(e.target.value)}
                />
              </div>
              <div className="form-group mb-3">
                <label className="form-label">New Password</label>
                <input
                  type="password"
                  className="form-control"
                  autoComplete="username"
                  placeholder="Enter password"
                  value={newPassword}
                  onChange={(e) => setNewPassword(e.target.value)}
                />
              </div>

              <button
                disabled={!newPassword || !oldPassword}
                className="btn btn-primary"
              >
                Submit
              </button>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default ChangePassword;
