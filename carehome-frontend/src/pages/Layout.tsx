import { Outlet } from "react-router";

const Layout = () => {
  return (
    <div>
      <p>Hello, from Layout</p>
      <Outlet />
      <p>Hello, from footer</p>
    </div>
  );
};

export default Layout;
