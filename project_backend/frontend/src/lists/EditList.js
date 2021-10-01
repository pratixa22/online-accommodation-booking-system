import { useState, useEffect } from "react";
import { toast } from "react-toastify";
import { Select } from "antd";
import axios from "axios";
import { useHistory } from "react-router-dom";
import constants from "../auth/constants";

const { Option } = Select;

const EditList = ({ match }) => {
  const url = constants.server;
  const history = useHistory();
  const accId = match.params.id;
  // state
  const [values, setValues] = useState({
    title: "",
    image: "",
    description: "",
    price: "",
    guest: 0,
    type: "",
    location: "",
    thumbnail: "",
  });
  const [preview, setPreview] = useState(
    "https://via.placeholder.com/100x100.png?text=PREVIEW"
  );
  // destructuring variables from state
  const { title, description, image, price, guest, thumbnail, type, location } =
    values;

  useEffect(() => {
    const getUser = () => {
      axios
        .get(url + `/acc/accId/${accId}`)
        .then((res) => {
          setValues(res.data.data);
        })
        .catch((err) => {});
    };
    getUser();
  }, [accId, url]);

  const handleSubmit = async (e) => {
    e.preventDefault();

    let hotelData = new FormData();
    hotelData.append("title", title);
    hotelData.append("description", description);
    hotelData.append("price", price);
    hotelData.append("location", location);
    hotelData.append("type", type);
    image && hotelData.append("thumbnail", image);
    hotelData.append("guest", guest);
    console.log([...hotelData]);

    try {
      const res = await axios
        .put(url + `/acc/editAcco/${accId}`, hotelData)
        .then((response) => {});
      // let res = await put.(token, hotelData, match.params.hotelId);
      toast.success("Accommodation Updated");
      console.log("Accommodation Updated ===> ", res);
      history.push("/dashboard/host");
    } catch (err) {
      console.log(err);
      if (err.response.status === 400) toast.error(err.response.data);
    }
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
          name="description"
          onChange={handleChange}
          placeholder="description"
          className="form-control m-2"
          value={description}
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
          onChange={(value) => setValues({ ...values, guest: value })}
          className="w-100 m-2"
          size="large"
          placeholder="Number of beds"
        >
          <Option key={1}>{1}</Option>
          <Option key={2}>{2}</Option>
          <Option key={3}>{3}</Option>
          <Option key={4}>{4}</Option>
        </Select>

        <Select
          onChange={(value) => setValues({ ...values, type: value })}
          className="w-100 m-2"
          size="large"
          placeholder="Type of Accommodation"
        >
          <Option key={"Flat"}>{"Flat"}</Option>
          <Option key={"Room"}>{"Room"}</Option>
          <Option key={"Hotel"}>{"Hotel"}</Option>
          <Option key={"Bunglow"}>{"Bunglow"}</Option>
        </Select>
      </div>

      <button className="btn btn-outline-primary m-2">Update</button>
    </form>
  );

  return (
    <>
      <div className="container-fluid bg-light p-1.5 text-center">
        <h2>Add Hotel</h2>
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
            <img
              src={url + "/" + thumbnail}
              alt=""
              className="card-image img img-fluid"
            />

            <pre>{JSON.stringify(values, null, 4)}</pre>
          </div>
        </div>
      </div>
    </>
  );
};

export default EditList;
