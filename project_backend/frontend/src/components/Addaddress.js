import axios from "axios";
import { useState } from "react";
import { useHistory } from "react-router-dom";
import { toast } from "react-toastify";
import constants from "../auth/constants";

const AddAddress = ({ match }) => {
  const history = useHistory();
  const accoId = match.params.aid;
  // state

  const [addressLine1, setAddressLine1] = useState("");
  const [addressLine2, setAddressLine2] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [pincode, setPincode] = useState("");
  const url = constants.server;
  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.post(url + "/acc/address/new", {
        accoId,
        addressLine1,
        addressLine2,
        city,
        state,
        pincode,
      });
      if (res.data) {
      }
      // let res = await put.(token, hotelData, match.params.hotelId);
      toast.success("Address Added!");

      history.push("/dashboard/host");
    } catch (err) {
      console.log(err);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="form-group m-5 p-4">
        <textarea
          name="addressLine1"
          onChange={(e) => setAddressLine1(e.target.value)}
          placeholder="addressLine1"
          className="form-control m-2"
          value={addressLine1}
        />
        <textarea
          name="addressLine2"
          onChange={(e) => setAddressLine2(e.target.value)}
          placeholder="addressLine2"
          className="form-control m-2"
          value={addressLine2}
        />
        <input
          type="text"
          name="city"
          onChange={(e) => setCity(e.target.value)}
          placeholder="city"
          className="form-control m-2"
          value={city}
        />
        <input
          type="text"
          name="state"
          onChange={(e) => setState(e.target.value)}
          placeholder="state"
          className="form-control m-2"
          value={state}
        />
        <input
          type="number"
          name="pincode"
          onChange={(e) => setPincode(e.target.value)}
          placeholder="pincode"
          className="form-control m-2"
          value={pincode}
        />
        <button className="btn btn-outline-primary m-2">Add Address</button>
      </div>
    </form>
  );
};

export default AddAddress;
