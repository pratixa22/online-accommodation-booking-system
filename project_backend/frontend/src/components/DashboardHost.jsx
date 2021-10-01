import { useEffect, useState } from "react";
import DashboardNav from "../components/DashboardNav";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";

import axios from "axios";
import SmallCard from "./cards/SmallCard";
import constants from "../auth/constants";

const DashboardHost = () => {
  const [accommodations, setAccommodations] = useState([]);
  const { auth } = useSelector((state) => ({ ...state }));
  const id = auth.id;
  const url = constants.server;
  useEffect(() => {
    const loadList = async () => {
      let res = await axios.get(url + `/acc/userAcco/${id}`);
      setAccommodations(res.data.data);
    };
    loadList();
  }, [id, url]);

  return (
    <>
      <div className="container-fluid bg-light p-2">
        {
          <div className="d-flex justify-content-around mb-0 h3 text-secondary">
            Welcome {auth.firstName}
          </div>
        }
      </div>

      <div className="container-fluid p-4">
        <DashboardNav />
      </div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-10">
            <h2>Welcome Host</h2>
          </div>
          <div className="col-md-2">
            <Link to="/newlist" className="btn btn-primary">
              + Add Accommodation
            </Link>
          </div>
        </div>
      </div>
      <div className="container-fluid">
        <br />
        {/* <pre>{JSON.stringify(accommodations, null, 4)}</pre> */}
        {accommodations.map((h, k) => (
          <SmallCard key={k} h={h} />
        ))}
      </div>
    </>
  );
};

export default DashboardHost;
