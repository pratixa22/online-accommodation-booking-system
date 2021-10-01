import { useState, useEffect } from "react";
import queryString from "query-string";

import axios from "axios";
import SmallCard from "../components/cards/SmallCard";
import Search from "../booking/Search";
import constants from "../auth/constants";

const SearchList = () => {
  const [hotels, setHotels] = useState([]);
  const url = constants.server;
  // when component mounts, get search params from url and use to send search query to backend
  useEffect(() => {
    // const { location, date, bed } = queryString.parse(window.location.search);
    const { location } = queryString.parse(window.location.search);
    const res = () =>
      axios.get(url + `/acc/${location}`).then((res) => {
        setHotels(res.data.data);
      });
    res();
    // console.table({ location, date, bed });
  }, [url]);

  return (
    <>
      <div className="col">
        <br />
        <Search />
      </div>
      <div className="container">
        <div className="row">
          {hotels.map((h, k) => (
            <SmallCard key={k} h={h} />
          ))}
        </div>
      </div>
    </>
  );
};

export default SearchList;
