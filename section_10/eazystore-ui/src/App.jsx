// import Header, {Header1} from "./components/Header";
import MyHeader from "./components/Header";
import Footer from "./components/footer/Footer";
import Home from "./components/Home";
import React from "react";
import { Outlet } from "react-router-dom";
import { useNavigation } from "react-router-dom";

function App() {
  const navigation = useNavigation();
  return (
    // for new react version, we can just use <> and </>
    // <React.Fragment>
    <>
      <MyHeader />
      {navigation.state === "loading" ? (
        <div className="flex items-center justify-center min-h-[852px]">
          <span className="text-4xl font-semibold text-primary dark:text-light">
            Loading...
          </span>
        </div>
      ) : (
        <Outlet />
      )}

      <Footer />
    </>
    // </React.Fragment>
  );
}

export default App;
