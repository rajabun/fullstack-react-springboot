import React from "react";
//import { useParams } from "react-router-dom";
import { useLocation } from "react-router-dom";

export default function ProductDetail() {
  //const params = useParams();
  const location = useLocation();
  const product = location.state?.product;

  return <div>{product.name}</div>;
}
