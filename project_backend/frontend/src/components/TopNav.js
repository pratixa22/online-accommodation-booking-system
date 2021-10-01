import { Link } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { useHistory } from "react-router";

const TopNav = () => {
  const dispatch = useDispatch();
  const { auth } = useSelector((state) => ({ ...state }));
  const history = useHistory();

  const logout = () => {
    dispatch({
      type: "LOGOUT",
      payload: null,
    });
    window.localStorage.removeItem("auth");
    history.push("/login");
  };
  return (
    <div>
      <div className="  navbar-light bg-light bg-light d-flex justify-content-between">
        <Link className="navbar-brand p-1" to="/">
          &nbsp;&nbsp;
          {/* <img className="logo-sm" src="./img1.jpeg"></img>&nbsp;&nbsp; */}
          <img
            className="logo-sm"
            src="https://cdn.worldvectorlogo.com/logos/bootstrap-icon.svg"
            alt="img"
          ></img>
          &nbsp;&nbsp; Online Accommodation Booking System
        </Link>
        <Link className="nav-link p-3" to="/">
          Home
        </Link>

        {/*  */}
        {auth !== null && (
          <>
            <Link className="nav-link p-3" to="/dashboard">
              Dashboard
            </Link>

            {auth.role === "user" && (
              <>
                <Link className="nav-link p-3  " to="/dashboard/host">
                  Become Host
                </Link>
              </>
            )}
            <button
              className=" nav-link btn btn-light btn-sm "
              onClick={logout}
            >
              Logout
            </button>

            {/* <a className="nav-link pointer" onClick={logout}>
              Logout
            </a> */}
          </>
        )}

        {auth === null && (
          <>
            <Link className="nav-link p-3 " to="/login">
              Login
            </Link>
            <Link className="nav-link p-3" to="/register">
              Register
            </Link>
          </>
        )}
      </div>
    </div>
  );
};

export default TopNav;
