import { BrowserRouter, Switch, Route } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import "antd/dist/antd.css";
import TopNav from "./components/TopNav";
import PrivateRoute from "./components/PrivateRoute";
//componenets
import Home from "./booking/Home";
import Login from "./auth/Login";
import Register from "./auth/Register";
import Dashboard from "./user/Dashboard";
import ChangePassword from "./user/ChangePassword";
import EditProfile from "./user/EditProfile";
import DashboardHost from "./components/DashboardHost";
import DashboardBook from "./components/DashboardBook";
import NewHotel from "./lists/NewHotel";
import ViewHotel from "./lists/ViewHotel";
import EditList from "./lists/EditList";
import SearchList from "./lists/SearchList";
import PayHotel from "./booking/PayHotel";

import DashboardAcco from "./Admin/DashboardAcco";
import DashboardAdminHost from "./Admin/DashboardAdminHost";
import DashboardAdminOrder from "./Admin/DashboardAdminOrder";
import UserProfile from "./Admin/UserProfile";
import AddReview from "./components/AddReview";
import AddAddress from "./components/Addaddress";
import DashboardHostOrder from "./booking/DashboardHostOrder";
import DashboardAdminUser from "./Admin/DashboardAdminUser";

function App() {
  return (
    <BrowserRouter>
      <TopNav />
      <ToastContainer position="top-center" />
      <Switch>
        <Route exact path="/" component={Home} />
        <Route exact path="/login" component={Login} />
        <Route exact path="/register" component={Register} />
        <PrivateRoute exact path="/dashboard" component={Dashboard} />
        <PrivateRoute exact path="/profile" component={EditProfile} />
        <PrivateRoute exact path="/changepw/" component={ChangePassword} />
        <PrivateRoute exact path="/dashboard/host" component={DashboardHost} />
        <PrivateRoute exact path="/dashboard/book" component={DashboardBook} />
        <Route exact path="/newlist" component={NewHotel} />
        <Route exact path="/list/:id" component={ViewHotel} />
        <Route exact path="/list/book/:id" component={PayHotel} />
        <PrivateRoute exact path="/list/edit/:id" component={EditList} />
        <Route exact path="/search-result" component={SearchList} />
        <PrivateRoute
          exact
          path="/dashboard/admin/host"
          component={DashboardAdminHost}
        />
        <PrivateRoute
          exact
          path="/dashboard/admin/user"
          component={DashboardAdminUser}
        />
        <PrivateRoute
          exact
          path="/dashboard/admin/Acco"
          component={DashboardAcco}
        />
        <PrivateRoute
          exact
          path="/dashboard/admin/orders"
          component={DashboardAdminOrder}
        />
        <PrivateRoute
          exact
          path="/dashboard/host/orders"
          component={DashboardHostOrder}
        />
        <PrivateRoute
          exact
          path="/admin/user/profile/:id"
          component={UserProfile}
        />
        <PrivateRoute exact path="/review/add/:id" component={AddReview} />
        <PrivateRoute exact path="/address/add/:aid" component={AddAddress} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
