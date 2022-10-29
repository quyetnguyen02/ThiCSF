<template>
  <form v-on:submit.prevent="submitForm">
    <div class="form-group">
      <label for="recipient-name" class="col-form-label">Quantity:</label>
      <input type="text" name="quantity" class="form-control" id="recipient-name">
    </div>
    <button type="submit" class="btn btn-danger">Submit</button>
  </form>
</template>
<script setup>
import { useRoute } from "vue-router";
import axios from "axios";

const router = new useRoute();
function submitForm(submitEvent) {
  const quantity = submitEvent.target.elements.quantity.value;
  const id = router.params.id;

  axios({
    method: 'post',
    url: 'http://localhost:8080/product',
    header: {},
    data: {
      id: id,
      quantity: quantity,
    }
  }).then(res => {
    console.log(res)
    if (res.status === 200){
      alert('update quantity success');
      window.location.href = '/';
    }
    else
      alert("đã sảy lỗi vui lòng thử lại sau")
  })
}

</script>