import {
  CardHeader,
  Card,
  CardActions,
  CardContent,
  IconButton,
  Typography,
  Button,
} from "@mui/material";
import FavoriteIcon from "@mui/icons-material/Favorite";
import { FunctionComponent, useState, useEffect } from "react";
import { ProductType, UserType } from "../type";
import axios from "axios";

type ProductProps = {
  product: ProductType;
  user?: UserType;
};

const Product: FunctionComponent<ProductProps> = ({ product, user }) => {
  const [favorite, setFavorite] = useState(false);
  const [favorites, setFavorites] = useState<ProductType[]>([]);
  useEffect(() => {
    if (user) {
      axios
        .get(`https://localhost/account/${user.id}/favorite`)
        .then((_res: any) => {
          console.log(_res.data);
          setFavorites(_res.data);
          favorites.forEach((f) => {
            if (f.id === product.id) {
              setFavorite(true);
            }
          });
        });
    }
  }, [user]);
  /**
   * Need to be logged to be abble to add a favorite
   */
  const addFavorite = () => {
    if (user) {
      axios({
        method: "post",
        url: "https://localhost/favorite/add",
        headers: {},
        data: {
          accountid: user.id,
          productid: product.id,
        },
      }).then((_res: any) => {
        console.log(_res.data);
        setFavorite(true);
      });
    }
  };
  const removeFavorite = () => {
    if (user) {
      axios({
        method: "post",
        url: "https://localhost/favorite/remove",
        headers: {},
        data: {
          accountid: user.id,
          productid: product.id,
        },
      }).then((_res: any) => {
        console.log(_res.data);
        setFavorite(false);
      });
    }
  };
  console.log(favorites);
  return (
    <Card sx={{ minWidth: 345, mt: 3 }}>
      <CardHeader title={product.name} subheader={product.category} />

      <CardContent>
        <h3>Price:</h3>
        <p>{product.price} USD</p>
        <p>{product.bitcoin} BTC</p>
        <p>{product.ethereum} ETH</p>
      </CardContent>
      <CardActions disableSpacing>
        {favorite ? (
          <Button variant="contained" color="error" onClick={removeFavorite}>
            Remove favorite
          </Button>
        ) : (
          <Button variant="contained" onClick={addFavorite}>
            Add favorite
          </Button>
        )}
      </CardActions>
    </Card>
  );
};

export default Product;
