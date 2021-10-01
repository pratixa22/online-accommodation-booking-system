import React, { useState } from "react";
import { DatePicker, Select } from "antd";
import { SearchOutlined } from "@ant-design/icons";
import moment from "moment";
import { useHistory } from "react-router-dom";

const { RangePicker } = DatePicker;
const { Option } = Select;

const Search = () => {
  // state
  const [location, setLocation] = useState("");
  const [date, setDate] = useState("");
  const [bed, setBed] = useState("");
  // route
  const history = useHistory();

  const handleSubmit = () => {
    console.log(location);
    history.push(`/search-result?location=${location}&date=${date}&bed=${bed}`);
  };

  return (
    <div className="d-flex p-2 m-1 bg-secondary">
      <div className="w-100">
        <input
          type="text"
          placeholder="Location"
          // defaultValue={location}  error in console
          className="form-control"
          value={location}
          style={{ height: "50px" }}
          onChange={(e) => setLocation(e.target.value)}
        />
      </div>

      <RangePicker
        onChange={(value, dateString) => setDate(dateString)}
        disabledDate={(current) =>
          current && current.valueOf() < moment().subtract(1, "days")
        }
        className="w-100"
      />

      <Select
        onChange={(value) => setBed(value)}
        className="w-100"
        size="large"
        placeholder="Number of beds"
      >
        <Option key={1}>{1}</Option>
        <Option key={2}>{2}</Option>
        <Option key={3}>{3}</Option>
        <Option key={4}>{4}</Option>
      </Select>

      <SearchOutlined
        onClick={handleSubmit}
        className="btn btn-primary p-3 btn-square"
      />
    </div>
  );
};

export default Search;
