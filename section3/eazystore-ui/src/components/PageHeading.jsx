import React from "react";
import PageTitle from "./PageTitle";

export default function PageHeading(props) {
  return (
    <div className="page-heading-container">
      <PageTitle title={props.title} />
      <p className="page-heading-paragraph">{props.children}</p>
    </div>
  );
}

/* other way to write props
export default function PageHeading({ title, children }) {
  return (
    <div className="page-heading-container">
      <PageTitle title={title} />
      <p className="page-heading-paragraph">{children}</p>
    </div>
  );
}
*/
