import axios from "axios";
import { useState } from "react";
import { toast } from "react-toastify";
import { Select } from "antd";
// import moment from "moment";
import { useSelector } from "react-redux";
import constants from "../auth/constants";
// import { createList } from "../actions/list";

const { Option } = Select;
const NewHotel = ({ history }) => {
  //redux
  const { auth } = useSelector((state) => ({ ...state }));
  const id = auth.id;
  const url = constants.server;
  // state
  const [values, setValues] = useState({
    title: "",
    content: "",
    location: "",
    image: "",
    price: "",
    bed: "",
    type: "",
  });
  const [preview, setPreview] = useState(
    "https://via.placeholder.com/100x100.png?text=PREVIEW"
  );
  // destructuring variables from state
  const { title, content, location, image, price, bed, type } = values;

  const handleSubmit = async (e) => {
    e.preventDefault();

    let hotelData = new FormData();
    hotelData.append("userId", id);
    hotelData.append("title", title);
    hotelData.append("description", content);
    hotelData.append("location", location);
    hotelData.append("price", price);
    image && hotelData.append("thumbnail", image);
    // hotelData.append("from", from);
    hotelData.append("guest", bed);
    hotelData.append("type", type);

    let res = await axios.post(url + `/acc/addAcco`, hotelData);

    let aid = res.data.data.id;
    toast.success("New Listing is posted");
    history.push(`/address/add/${aid}`);
  };

  const handleImageChange = (e) => {
    // console.log(e.target.files[0]);
    setPreview(URL.createObjectURL(e.target.files[0]));
    setValues({ ...values, image: e.target.files[0] });
  };

  const handleChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const hotelForm = () => (
    <form onSubmit={handleSubmit}>
      <div className="form-group">
        <label className="btn btn-outline-secondary btn-block m-2 text-left">
          Image
          <input
            type="file"
            name="image"
            onChange={handleImageChange}
            accept="image/*"
            hidden
          />
        </label>

        <input
          type="text"
          name="title"
          onChange={handleChange}
          placeholder="Title"
          className="form-control m-2"
          value={title}
        />

        <textarea
          name="content"
          onChange={handleChange}
          placeholder="Content"
          className="form-control m-2"
          value={content}
        />

        <input
          type="text"
          name="location"
          onChange={handleChange}
          placeholder="location"
          className="form-control m-2"
          value={location}
        />

        <input
          type="number"
          name="price"
          onChange={handleChange}
          placeholder="Price"
          className="form-control m-2"
          value={price}
        />
        <Select
          onChange={(value) => setValues({ ...values, bed: value })}
          className="w-100 m-2"
          size="large"
          placeholder="Number of beds"
        >
          <Option key={1}>{1}</Option>
          <Option key={2}>{2}</Option>
          <Option key={3}>{3}</Option>
          <Option key={4}>{5}</Option>
        </Select>
        <Select
          onChange={(value) => setValues({ ...values, type: value })}
          className="w-100 m-2"
          size="large"
          placeholder="Type of Accommodation"
        >
          <Option key={"Flat"}>{"Flat"}</Option>
          <Option key={"Bunglow"}>{"Bunglow"}</Option>
          <Option key={"Room"}>{"Room"}</Option>
          <Option key={"Hotel"}>{"Hotel"}</Option>
        </Select>
      </div>

      <button className="btn btn-outline-primary m-2">Save</button>
    </form>
  );

  return (
    <>
      <div className="container-fluid bg-light p-1.5 text-center">
        <h2>Add Accommodation</h2>
      </div>
      <div className="container-fluid">
        <div className="row">
          <div className="col-md-10">
            <br />
            {hotelForm()}
          </div>
          <div className="col-md-2">
            <img
              src={preview}
              alt="preview_image"
              className="img img-fluid m-2"
            />
          </div>
        </div>
      </div>
    </>
  );
};

export default NewHotel;
