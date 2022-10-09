export type ProductType = {
  id: number;
  name: string;
  category: string;
  price: number;
  bitcoin: number;
  ethereum: number;
  favorite: boolean;
};

export type UserType = {
  id: number;
  email: string;
  name: string;
  password: string;
};
