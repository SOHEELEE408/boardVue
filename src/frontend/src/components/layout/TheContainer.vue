<template>
  <div class="wrapper">
    <Header/>
    <div class="content-view">
      <router-view/>
    </div>
  </div>
</template>

<script>
import Header from "@/components/layout/Header";
export default {
  components:{Header},
  name: "TheContainer"
}
</script>

<style scoped>

</style>