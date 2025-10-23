// import Header, {Header1} from "./components/Header";
import MyHeader from "./components/Header";
import ClassHeader from "./components/ClassHeader";
import Footer from "./components/footer/Footer";
import Home from "./components/Home";
import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    // for new react version, we can just use <> and </>
    // <React.Fragment>
    <>
      <MyHeader />
      <Home />
      <Footer />
    </>
    // </React.Fragment>
  );
}

export default App;
