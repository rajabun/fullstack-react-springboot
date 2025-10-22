import React from "react";

export default function PageTitle({ title }) {
  return <h1 className="page-title">{title}</h1>;
}

/* default way to use props
export default function PageTitle(props) {
  console.log(props);
  return <h1 className="page-title">{props.title}</h1>;
}
*/
