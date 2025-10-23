import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHeart } from "@fortawesome/free-solid-svg-icons";
// import "./footer.css";
import styles from "./footer.module.css";
import styled from "styled-components";
import EazyButton from "../EazyButton";

const H1 = styled.h1`
  color: #5b21b6;
  text-align: center;
`;

export default function Footer() {
  const isActive = Math.random() > 0.5;

  return (
    <>
      {/* <h1
        style={{
          textAlign: "center",
          color: isActive ? "#5b21b6" : "#333",
        }}
      >
        Demo of Global CSS Scope from Footer with CSS Inline Styles
      </h1> */}

      {/* <h1 className="my-heading">Demo of Global CSS Scope from Footer with common CSS</h1> */}

      {/* <h1
        className={`${styles["my-heading"]} ${
          isActive ? styles["primary-color"] : styles["secondary-color"]
        }`}
      >
        Demo of Global CSS Scope from Footer with CSS Modules
      </h1> */}

      <H1>Demo of Styled Components from Footer</H1>
      <EazyButton>Submit</EazyButton>
      <footer className={styles.footer}>
        Built with
        <FontAwesomeIcon
          icon={faHeart}
          className={styles["footer-icon"]}
          aria-hidden="true"
        />
        by
        <a href="https://eazybytes.com/" target="_blank" rel="noreferrer">
          eazybytes
        </a>
      </footer>
    </>
  );
}
