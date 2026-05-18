// import Header, {Header1} from "./components/Header";
import MyHeader from "./components/Header";
import Footer from "./components/footer/Footer";
import Home from "./components/Home";
import React from "react";
import { Outlet } from "react-router-dom";

function App() {
  return (
    // for new react version, we can just use <> and </>
    // <React.Fragment>
    <>
      <MyHeader />
      <Outlet />
      <Footer />
    </>
    // </React.Fragment>
  );
}

export default App;
