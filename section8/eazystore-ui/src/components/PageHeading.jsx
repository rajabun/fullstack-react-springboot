import React from "react";
import PageTitle from "./PageTitle";

export default function PageHeading(props) {
  return (
    <div className="text-center max-w-[576px] mx-auto px-4 py-6">
      <PageTitle title={props.title} />
      <p className="font-primary leading-6 text-gray-600">{props.children}</p>
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
