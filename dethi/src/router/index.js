import { createRouter, createWebHistory } from 'vue-router'
import ListProduct from "@/views/ListProduct.vue";
import CreateProduct from "@/views/CreateProduct.vue";
import EditProduct from "@/views/UpdateProduct.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'listProduct',
      component: ListProduct
    },
    {
      path: '/create',
      name: 'create',
      component: CreateProduct
    },
    {
      path: '/edit/:id',
      name: 'edit',
      component: EditProduct
    },
  ]
})

export default router
