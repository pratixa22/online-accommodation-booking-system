import { useEffect, useState } from "react";

import axios from "axios";

import HostRow from "./components/HostRow";
import DashboardNav from "../components/DashboardNav";
import constants from "../auth/constants";

const DashboardAdminUser = () => {
  const [hosts, setHosts] = useState([]);
  const url = constants.server;
  useEffect(() => {
    const loadHosts = async () => {
      let res = await axios.get(url + "/userAll");
      setHosts(res.data.data);
    };
    loadHosts();
  }, [url]);

  return (
    <>
      <div className="container-fluid bg-light p-1">
        <div className="d-flex justify-content-around h1">Admin Portal</div>
      </div>
      <div className="container-fluid p-1">
        <DashboardNav />
      </div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-10"></div>
          <div className="col-md-2"></div>
        </div>
        <br />
        <div className="container">
          <table className="table table-striped">
            <thead>
              <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone no.</th>
                <th>Date of Birth</th>
                <th>Id Proof</th>
                <th>Approval </th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {hosts.map((host, k) => {
                return <HostRow key={k} host={host} />;
              })}
            </tbody>
          </table>
          {/* <pre>{JSON.stringify(hosts, null, 4)}</pre> */}
        </div>
      </div>
    </>
  );
};

export default DashboardAdminUser;
