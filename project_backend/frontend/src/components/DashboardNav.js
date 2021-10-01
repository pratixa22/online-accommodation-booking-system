import React from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
const DashboardNav = () => {
  // current url
  const { auth } = useSelector((state) => ({ ...state }));
  const role = auth.role;
  const active = window.location.pathname;
  //console.log(active);
  return (
    <div>
      <ul className="nav nav-tabs">
        <li className="nav-item">
          <Link
            className={`nav-link ${active === "/dashboard" && "active"}`}
            to="/dashboard"
          >
            Your Profile
          </Link>
        </li>

        <li className="nav-item">
          {role !== "admin" && (
            <Link
              className={`nav-link ${active === "/dashboard/book" && "active"}`}
              to="/dashboard/book"
            >
              Your Booking
            </Link>
          )}
        </li>
        <li className="nav-item">
          {role !== "admin" && (
            <Link
              className={`nav-link ${active === "/dashboard/host" && "active"}`}
              to="/dashboard/host"
            >
              Your Listing
            </Link>
          )}
        </li>
        <li className="nav-item">
          {role === "admin" && (
            <Link
              className={`nav-link ${
                active === "/dashboard/admin/host" && "active"
              }`}
              to="/dashboard/admin/host"
            >
              Hosts
            </Link>
          )}
        </li>

        <li className="nav-item">
          {role === "admin" && (
            <Link
              className={`nav-link ${
                active === "/dashboard/admin/user" && "active"
              }`}
              to="/dashboard/admin/user"
            >
              Users
            </Link>
          )}
        </li>

        <li className="nav-item">
          {role === "admin" && (
            <Link
              className={`nav-link ${
                active === "/dashboard/admin/Acco" && "active"
              }`}
              to="/dashboard/admin/Acco"
            >
              Accommodations
            </Link>
          )}
        </li>
        <li className="nav-item">
          {role === "admin" && (
            <Link
              className={`nav-link ${
                active === "/dashboard/admin/orders" && "active"
              }`}
              to="/dashboard/admin/orders"
            >
              Orders
            </Link>
          )}
        </li>
        <li className="nav-item">
          {role === "host" && (
            <Link
              className={`nav-link ${
                active === "/dashboard/host/orders" && "active"
              }`}
              to="/dashboard/host/orders"
            >
              Orders
            </Link>
          )}
        </li>
      </ul>
    </div>
  );
};

export default DashboardNav;
