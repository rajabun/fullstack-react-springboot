import products from "../data/products";
import PageHeading from "./PageHeading";
import ProductListings from "./ProductListings";
import EazyButton from "./EazyButton";
import BootstrapButton from "./BootstrapButton";

export default function Home() {
  // const isActive = Math.random() > 0.5;
  // const h1Styling = {
  //   textAlign: "center",
  //   color: isActive ? "black" : "red",
  // };

  return (
    <>
      {/* <h1
        className={`my-heading ${
          isActive ? "primary-color" : "secondary-color"
        }`}
      >
        Demo of Global CSS Scope from Home
      </h1>
      <EazyButton>Home</EazyButton> */}
      {/* <h1 style={h1Styling}>Demo of Global CSS Scope from Home with CSS Inline Styles</h1> */}
      {/* <h1 className="my-heading">Demo of Global CSS Scope from Home with common CSS</h1> */}

      <div className="home-container">
        {/* <button className="btn btn-primary">Submit</button> */}
        <div className="container col-6">
          <BootstrapButton text="Submit" type="primary" />
          <BootstrapButton text="Save" type="secondary" />
          <BootstrapButton text="Okay" type="success" />
          <BootstrapButton text="Cancel" type="danger" />
          <BootstrapButton text="Delete" type="warning" />
          <BootstrapButton text="Link" type="link" />
        </div>
        <div className="d-grid gap-2 col-8 mx-auto">
          <div class="alert alert-primary text-center" role="alert">
            A simple primary alert—check it out!
          </div>
          <div className="alert alert-secondary text-center" role="alert">
            A simple secondary alert—check it out!
          </div>
          <div className="alert alert-success text-center" role="alert">
            A simple success alert—check it out!
          </div>
          <div className="alert alert-danger text-center" role="alert">
            A simple danger alert—check it out!
          </div>
          <div className="alert alert-warning text-center" role="alert">
            A simple warning alert—check it out!
          </div>

          <div
            className="alert alert-warning alert-dismissible fade show text-center"
            role="alert"
          >
            <strong>Warning!</strong> This is a warning alert!
            <button
              type="button"
              className="btn-close"
              data-bs-dismiss="alert"
              aria-label="Close"
            ></button>
          </div>
        </div>
        <PageHeading title="Explore Eazy Stickers!">
          Add a touch of creativity to your space with our wide range of fun and
          unique stickers. Perfect for any occasion!
        </PageHeading>
        <ProductListings products={products} />
      </div>
    </>
  );
}
