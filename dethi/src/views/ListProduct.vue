<template>
  <div>
    <router-link to="create">
      Create Product
    </router-link>
  </div>
  <table class="table">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Quantity</th>
      <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody v-for="(product, key) in products">
      <tr>
        <th scope="row">{{ product.id }}</th>
        <td>{{ product.name }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.quantity }}</td>
        <td>
          <router-link :to="{ name: 'edit', params: { id: product.id }}">
            Update Product
          </router-link>
        </td>
      </tr>
    </tbody>
  </table>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const products = ref([]);
onMounted(() => {
  axios.get('http://localhost:8080/product').then(r => {
    products.value = r.data;
    console.log(products);

  }).catch((e) => {
    console.log(e);
  });

})
</script>