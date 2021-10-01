import { Select } from "antd";
import { useState } from "react";
import { toast } from "react-toastify";
import axios from "axios";
import { useSelector } from "react-redux";
import constants from "../auth/constants";

const AddReview = ({ match }) => {
  const { auth } = useSelector((state) => ({ ...state }));
  const userId = auth.id;
  const accoId = match.params.id;

  const [reviewText, setReviewText] = useState();
  const [rating, setRating] = useState();

  const { Option } = Select;
  const url = constants.server;
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.post(url + `/review/new`, {
        rating,
        reviewText,
        accoId,
        userId,
      });
      if (res.data) {
        //console.log(res.data);
      }
      toast.success("Review added");
    } catch (err) {}
  };
  console.log(rating);
  console.log(reviewText);
  return (
    <>
      <form onSubmit={handleSubmit}>
        <div className="form-group"></div>
        <div className="text-center">
          Review
          <Select
            onChange={(value) => setRating(value)}
            className="w-100 m-2"
            size="large"
            placeholder="Add Rating"
          >
            <Option key={1}>{1}</Option>
            <Option key={2}>{2}</Option>
            <Option key={3}>{3}</Option>
            <Option key={4}>{4}</Option>
            <Option key={5}>{5}</Option>
          </Select>
          <textarea
            name="Give feedback"
            onChange={(e) => setReviewText(e.target.value)}
            placeholder="Give feedback"
            className="form-control m-2"
            value={reviewText}
          />
          <button disabled={!rating || !reviewText} className="btn btn-primary">
            Submit
          </button>
        </div>
      </form>
    </>
  );
};
export default AddReview;
