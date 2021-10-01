import axios from "axios";
import React from "react";
import { toast } from "react-toastify";
import constants from "../../auth/constants";

const HostRow = ({ host, history }) => {
  const url = constants.server;
  const handleApproval = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.put(url + `/approveUser/${host.id}`);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 10);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  const handleDelete = async (e) => {
    e.preventDefault();

    try {
      const res = await axios.delete(url + `/delete/${host.id}`);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 10);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <tr>
      <td>{host.id}</td>

      <td>
        {host.firstName} {host.lastName}
      </td>
      <td>{host.email}</td>
      <td>{host.phoneNo}</td>
      <td>{host.dob}</td>
      <td>{host.idProof}</td>
      <td>
        <button
          onClick={handleApproval}
          className="btn btn-success btn-sm"
          disabled={host.approvalStatus === "approved"}
        >
          Approve
        </button>
      </td>

      <td>
        <button onClick={handleDelete} className="btn btn-danger btn-sm">
          Delete
        </button>
      </td>
    </tr>
  );
};

export default HostRow;
