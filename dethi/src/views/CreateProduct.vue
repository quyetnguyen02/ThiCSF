<template>
  <form v-on:submit.prevent="submitForm">
    <div class="form-group">
      <label for="recipient-name" class="col-form-label">Name:</label>
      <input type="text" name="name" class="form-control" id="recipient-name">
    </div>
    <div class="form-group">
      <label for="recipient-name" class="col-form-label">Price:</label>
      <input type="number" name="price" class="form-control" id="recipient-name">
    </div>
    <div class="form-group">
      <label for="recipient-name" class="col-form-label">Quantity:</label>
      <input type="text" name="quantity" class="form-control" id="recipient-name">
    </div>
    <button type="submit" class="btn btn-danger">Submit</button>
  </form>
</template>
<script setup>
import axios from "axios";

function submitForm(submitEvent) {
  const name = submitEvent.target.elements.name.value;
  const price = submitEvent.target.elements.price.value;
  const quantity = submitEvent.target.elements.quantity.value;

  axios({
    method: 'post',
    url: 'http://localhost:8080/product',
    header: {},
    data: {
      name: name,
      quantity: quantity,
      price: price,
    }
  }).then(res => {
    if (res.status === 200){
      alert('create quantity success');
      window.location.href = '/';
    }
    else
      alert("đã sảy lỗi vui lòng thử lại sau")
  })
}
</script>