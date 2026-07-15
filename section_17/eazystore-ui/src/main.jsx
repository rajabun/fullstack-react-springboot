import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import OrderSuccess from "./components/OrderSuccess.jsx";
import { ToastContainer, Bounce } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import Home, { productsLoader } from "./components/Home.jsx";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";
import About from "./components/About.jsx";
import Contact, { contactAction } from "./components/Contact.jsx";
import Login, { loginAction } from "./components/Login.jsx";
import Cart from "./components/Cart.jsx";
import ErrorPage from "./components/ErrorPage.jsx";
import ProductDetail from "./components/ProductDetail.jsx";
import { CartProvider } from "./store/cart-context.jsx";
import { AuthProvider } from "./store/auth-context.jsx";
import CheckoutForm from "./components/CheckoutForm.jsx";
import ProtectedRoute from "./components/ProtectedRoute.jsx";
import Profile, {
  profileLoader,
  profileAction,
} from "./components/Profile.jsx";
import Orders from "./components/Orders.jsx";
import AdminOrders from "./components/admin/AdminOrders.jsx";
import Messages from "./components/admin/Messages.jsx";
import Register, { registerAction } from "./components/Register.jsx";
import { loadStripe } from "@stripe/stripe-js";
import { Elements } from "@stripe/react-stripe-js";

const stripePromise = loadStripe(
  "pk_test_51TtJmAR03Sk1d0sXXBs0Q4AFLgWdsYBP9Cr63wXubj389hT1xTLnCCXfMUBcuipCJU1nC1YvoMHZZ8XGrtAfQsA500ZdTkrkQS",
);

//efficient writing for router
const routeDefinitions = createRoutesFromElements(
  <Route path="/" element={<App />} errorElement={<ErrorPage />}>
    <Route index element={<Home />} loader={productsLoader} />
    <Route path="/home" element={<Home />} loader={productsLoader} />
    <Route path="/about" element={<About />} />
    <Route path="/contact" element={<Contact />} action={contactAction} />
    <Route path="/login" element={<Login />} action={loginAction} />
    <Route path="/register" element={<Register />} action={registerAction} />
    <Route path="/cart" element={<Cart />} />
    <Route path="/products/:productId" element={<ProductDetail />} />
    <Route element={<ProtectedRoute />}>
      <Route path="/checkout" element={<CheckoutForm />} />
      <Route path="/order-success" element={<OrderSuccess />} />
      <Route
        path="/profile"
        element={<Profile />}
        loader={profileLoader}
        action={profileAction}
        shouldRevalidate={({ actionResult }) => {
          return !actionResult?.success;
        }}
      />
      <Route path="/orders" element={<Orders />} />
      <Route path="/admin/orders" element={<AdminOrders />} />
      <Route path="/admin/messages" element={<Messages />} />
    </Route>
  </Route>,
);

const appRouter = createBrowserRouter(routeDefinitions);

createRoot(document.getElementById("root")).render(
  //StrictMode is used to render component twice to find common bugs. Used for development only
  <StrictMode>
    <Elements stripe={stripePromise}>
      <AuthProvider>
        <CartProvider>
          <RouterProvider router={appRouter} />
        </CartProvider>
      </AuthProvider>
      <ToastContainer
        position="top-center"
        autoClose={3000}
        hideProgressBar={false}
        newestOnTop={false}
        draggable
        pauseOnHover
        theme={localStorage.getItem("theme") === "dark" ? "dark" : "light"}
        transition={Bounce}
      />
    </Elements>
  </StrictMode>,
);
