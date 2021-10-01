import axios from "axios";
import { toast } from "react-toastify";
import constants from "../../auth/constants";

const AccommodationRow = ({ accommodation }) => {
  const handleDelete = async (e) => {
    const url = constants.server + `/acc/delete/${accommodation.id}`;
    e.preventDefault();

    try {
      const res = await axios.delete(url);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 10);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };
  const url = constants.server;

  const handleApproval = async (e) => {
    const url = constants.server + `/acc/approveAcco/${accommodation.id}`;
    e.preventDefault();

    try {
      const res = await axios.put(url);
      toast.success(res.data);

      setTimeout(() => {
        window.location.reload();
      }, 1000);
    } catch (err) {
      console.log(err.response.data);
      if (err.response.status === 400) toast.error(err.response.data);
    }
  };

  return (
    <tr>
      <td>{accommodation.id}</td>

      <td>
        <img
          src={url + "/" + accommodation.thumbnail}
          alt=""
          className="thumbnail-sm"
        />
      </td>
      <td>{accommodation.title}</td>
      <td>{accommodation.type}</td>
      <td>{accommodation.location}</td>
      <td>{accommodation.guest}</td>
      <td>{accommodation.price}</td>
      <td>
        {accommodation.firstName} {accommodation.lastName}
      </td>

      <td>
        <button
          onClick={handleApproval}
          className="btn btn-success btn-sm"
          disabled={accommodation.status}
        >
          Approve
        </button>
      </td>

      <td>
        <button onClick={handleDelete} className="btn btn-danger btn-sm">
          Delete
        </button>
        {/* <pre>{JSON.stringify(accommodation, null, 4)}</pre> */}
      </td>
    </tr>
  );
};

export default AccommodationRow;
