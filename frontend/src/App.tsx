import { FormEventHandler, useEffect, useRef, useState } from "react";
import reactLogo from "./assets/react.svg";
import "./App.css";
import axios from "axios";
import Product from "./components/Product";
import { ProductType, UserType } from "./type";
import { Button, Stack, TextField } from "@mui/material";

function App() {
  const [products, setProducts] = useState<ProductType[]>([]);

  const [formValue, setFormvalue] = useState({ password: "", email: "" });
  const [user, setUser] = useState<UserType>();
  /**
   * Product
   */
  useEffect(() => {
    axios.get("https://localhost/products").then((_res: any) => {
      console.log(_res.data);
      setProducts(_res.data);
    });
  }, []);

  products.map((product) => {
    product.id;
  });
  /**
   * Login
   * @param e event
   */
  const submitHandler = (e: any) => {
    e.preventDefault();
    axios({
      method: "post",
      url: "https://localhost/account/login",
      headers: {},
      data: {
        email: formValue.email,
        password: formValue.password,
      },
    }).then((_res: any) => {
      console.log(_res.data);
      setUser(_res.data);
    });
  };

  const handleChange =
    (prop: string) => (event: React.ChangeEvent<HTMLInputElement>) => {
      setFormvalue({ ...formValue, [prop]: event.target.value });
    };

  return (
    <div className="App">
      {user ? (
        <>
          <p>Id : {user.name}</p>
          <p>Name : {user.name}</p>
          <p>Email : {user.email}</p>
        </>
      ) : (
        <form onSubmit={(e) => submitHandler(e)}>
          <h2>Login:</h2>{" "}
          <Stack bgcolor={"white"}>
            <>
              <TextField
                id="email"
                type={"email"}
                label="Email"
                variant="filled"
                onChange={handleChange("email")}
              />
              <TextField
                id="password"
                type={"password"}
                label="Password"
                variant="filled"
                onChange={handleChange("password")}
              />
              <Button type="submit">Login</Button>
            </>
          </Stack>
        </form>
      )}
      <h2>Products:</h2>
      {products.map((product) => {
        return <Product product={product} key={product.id} user={user} />;
      })}
    </div>
  );
}

export default App;
