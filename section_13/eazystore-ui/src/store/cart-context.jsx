import { createContext, useEffect, useContext, useReducer } from "react";

/*
const initialCartContext = {
  cart: [],
  setCart: () => {},
  addToCart: () => {
    console.log("Product added to cart");
  },
  removeFromCart: () => {},
  totalQuantity: 0,
};
*/

//STEP 1
// eslint-disable-next-line react-refresh/only-export-components
export const CartContext = createContext();

// eslint-disable-next-line react-refresh/only-export-components
export const useCart = () => useContext(CartContext);

const ADD_TO_CART = "ADD_TO_CART";
const REMOVE_FROM_CART = "REMOVE_FROM_CART";
const CLEAR_CART = "CLEAR_CART";

const cartReducer = (prevCart, action) => {
  switch (action.type) {
    case ADD_TO_CART:
      // eslint-disable-next-line no-case-declarations
      const { product, quantity } = action.payload;

      // eslint-disable-next-line no-case-declarations
      const existingItem = prevCart.find(
        (item) => item.productId === product.productId,
      );

      if (existingItem) {
        return prevCart.map((item) =>
          item.productId === product.productId
            ? { ...item, quantity: item.quantity + quantity }
            : item,
        );
      }

      // If the product is not in the cart, add it
      return [...prevCart, { ...product, quantity }];

    case REMOVE_FROM_CART:
      return prevCart.filter(
        (item) => item.productId !== action.payload.productId,
      );
    case CLEAR_CART:
      return [];
    default:
      return prevCart;
  }
};

//.Provider is for compatibility with older React version. not needed for React 19 and higher
export const CartProvider = ({ children }) => {
  const initialCartState = (() => {
    try {
      const storedCart = localStorage.getItem("cart");
      return storedCart ? JSON.parse(storedCart) : [];
    } catch (error) {
      console.error("Failed to parse cart from localStorage: ", error);
      return [];
    }
  })();

  const [cart, dispatch] = useReducer(cartReducer, initialCartState);

  /*
  // Initialize cart state from localStorage or as an empty array
  const [cart, setCart] = useState(() => {
    try {
      const storedCart = localStorage.getItem("cart");
      return storedCart ? JSON.parse(storedCart) : [];
    } catch (error) {
      console.error("Failed to parse cart from localStorage: ", error);
      return [];
    }
  });
  */

  // Save cart to localStorage whenever it changes
  useEffect(() => {
    try {
      localStorage.setItem("cart", JSON.stringify(cart));
    } catch (error) {
      console.error("Failed to save cart to localStorage", error);
    }
  }, [cart]);

  /*
  const addToCart = (product, quantity) => {
    setCart((prevCart) => {
      const existingItem = prevCart.find(
        (item) => item.productId === product.productId,
      );

      if (existingItem) {
        // Use map() to create a new array with updated quantity
        return prevCart.map((item) =>
          item.productId === product.productId
            ? { ...item, quantity: item.quantity + quantity }
            : item,
        );
      }

      // If the product is not in the cart, add it
      return [...prevCart, { ...product, quantity }];
    });
  };

  // Function to remove an item from the cart
  const removeFromCart = (productId) => {
    setCart((prevCart) =>
      prevCart.filter((item) => item.productId !== productId),
    );
  };
  */

  const addToCart = (product, quantity) => {
    dispatch({ type: ADD_TO_CART, payload: { product, quantity } });
  };

  const removeFromCart = (productId) => {
    dispatch({ type: REMOVE_FROM_CART, payload: { productId } });
  };

  // eslint-disable-next-line no-unused-vars
  const clearCart = () => {
    dispatch({ type: CLEAR_CART });
  };

  // Calculate total quantity
  const totalQuantity = cart.reduce((acc, item) => acc + item.quantity, 0);

  return (
    <CartContext.Provider
      value={{ cart, addToCart, removeFromCart, totalQuantity }}
    >
      {children}
    </CartContext.Provider>
  );
};
