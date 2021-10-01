import axios from "axios";
import { useState, useEffect } from "react";
import constants from "../auth/constants";
import SmallCard from "../components/cards/SmallCard";
import Search from "./Search";

const Home = () => {
  const [accommodations, setAccommodations] = useState([]);

  useEffect(() => {
    loadAccommodations();
  }, []);

  const loadAccommodations = async () => {
    const url = constants.server + `/acc/lists/verified`;
    let res = await axios.get(url);
    setAccommodations(res.data.data);
  };

  return (
    <>
      <div className="container-fluid bg-light p-0 text-center"></div>
      <div className="col bg-secondary p-1">
        {/* <br /> */}
        <Search />
      </div>

      <div className="container-fluid">
        <br />
        {/* <pre>{JSON.stringify(accommodations, null, 4)}</pre> */}
        {accommodations.map((h, i) => (
          // <SmallCard key={h._id} h={h} />
          <SmallCard key={i} h={h} />
        ))}
      </div>
      <div>
        <footer className="footer text-center">
          <a href="/#">About</a> &emsp; &emsp;
          <a href="/#">Contact Us </a> &emsp; &emsp;
          <a href="/#">Help Center </a>&emsp; &emsp;
          <a href="/#">Feedback</a>
        </footer>
      </div>
    </>
  );
};

export default Home;
