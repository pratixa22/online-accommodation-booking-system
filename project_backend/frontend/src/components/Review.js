//import { Select } from "antd";
import axios from "axios";
import { useEffect, useState } from "react";
import constants from "../auth/constants";

const Review = ({ hid }) => {
  const [reviews, setReviews] = useState([]);
  // const accId = match.params.id
  const url = constants.server;
  useEffect(() => {
    const getReviews = () => {
      axios
        .get(url + `/review/accoId/${hid}`)
        .then((response) => {
          setReviews(response.data.data);
        })
        .catch((err) => {});
    };
    getReviews();
  }, [hid, url]);

  return (
    <>
      <div className="text-center">Review</div>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>Id</th>
            <th>5 Star Rating</th>
            <th>feedback</th>
            <th>review date</th>
          </tr>
        </thead>
        <tbody>
          {reviews.map((review, k) => {
            return (
              <tr key={k}>
                <td>{review.id}</td>
                <td>{review.rating}</td>
                <td>{review.reviewText}</td>
                <td>{review.review_date}</td>
              </tr>
            );
          })}
        </tbody>
      </table>
      {/* <pre>{JSON.stringify(reviews, null, 4)}</pre> */}
    </>
  );
};
export default Review;
