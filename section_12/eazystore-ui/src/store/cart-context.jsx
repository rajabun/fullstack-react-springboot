import { createContext } from "react";

const initialCartContext = {
  cart: [],
  setCart: () => {},
  addToCart: () => {
    console.log("Product added to cart");
  },
  removeFromCart: () => {},
  totalQuantity: 0,
};

//STEP 1
// eslint-disable-next-line react-refresh/only-export-components
export const CartContext = createContext();

//.Provider is for compatibility with older React version. not needed for React 19 and higher
export const CartProvider = ({ children }) => {
  return (
    <CartContext.Provider value={initialCartContext}>
      {children}
    </CartContext.Provider>
  );
};
