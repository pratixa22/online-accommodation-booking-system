import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useDispatch } from "react-redux";
import constants from "./constants";

// useDispatch to update the state
const Login = ({ history }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const dispatch = useDispatch();

  // redux state vanish after refresh so store it in local storage
  const handleSubmit = async (e) => {
    const url = constants.server + "/login";
    e.preventDefault();

    try {
      const res = await axios.post(url, {
        email,
        password,
      });
      if (res.data) {
        //console.log(res.data);
        //save user and token to local storage
        window.localStorage.setItem("auth", JSON.stringify(res.data));
        //save user and token to redux
        dispatch({
          type: "LOGGED_IN_USER",
          payload: res.data,
        });

        history.push("/");
      }
      toast.success("Login success");
    } catch (err) {
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <>
      <div className="container-fluid bg-light p-1 text-center">
        <h1>Login</h1>
      </div>

      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3">
            <form onSubmit={handleSubmit} className="mt-3">
              <div className="form-group mb-3">
                <label className="form-label">Email address</label>
                <input
                  type="email"
                  className="form-control"
                  placeholder="Enter email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>

              <div className="form-group mb-3">
                <label className="form-label">Password</label>
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter password"
                  autoComplete="username"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                />
              </div>

              <button
                disabled={!email || !password}
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

export default Login;
