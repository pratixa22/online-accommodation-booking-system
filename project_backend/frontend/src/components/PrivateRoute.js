import { Route, Redirect } from "react-router";
import { useSelector } from "react-redux";

const PrivateRoute = ({ ...rest }) => {
  const { auth } = useSelector((state) => ({ ...state }));

  return auth && auth.id ? <Route {...rest} /> : <Redirect to="/login" />;
};
export default PrivateRoute;
