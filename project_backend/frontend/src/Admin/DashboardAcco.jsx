import { useEffect, useState } from "react";
import DashboardNav from "../components/DashboardNav";

import axios from "axios";
import AccommodationRow from "./components/AccommodationRow";
import constants from "../auth/constants";

const DashboardAcco = () => {
  const [accommodations, setAccommodations] = useState([]);
  const url = constants.server;
  useEffect(() => {
    const loadAccommodations = async () => {
      let res = await axios.get(url + "/acc/listAll");
      setAccommodations(res.data.data);
    };
    loadAccommodations();
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
          <div className="col-md-10">
            <br />
          </div>
          <div className="col-md-2">
            {/* <button className=" nav-link btn btn-light">All Orders</button> */}
          </div>
        </div>
        <div className="container">
          <table className="table table-striped">
            <thead>
              <tr>
                <th>id</th>
                <th>Image</th>
                <th>title</th>
                <th>type</th>
                <th>location</th>
                <th>guest</th>
                <th>price</th>
                <th>host Name</th>
                <th>Approval </th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {/* {albums.map((album) => {
              return <AlbumRow album={album} />;
            })} */}
              {accommodations.map((accommodation, k) => {
                return (
                  <AccommodationRow accommodation={accommodation} key={k} />
                );
              })}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default DashboardAcco;
