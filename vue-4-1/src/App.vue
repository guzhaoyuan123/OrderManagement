<template>
  <div id="app">
    <div id="hh"></div>
    <router-view />
  </div>
</template>
<script>
  export default {
    name: "App",
    methods: {
      toHome() {
        this.$router.push("/home");
      },
      toAbout() {
        this.$router.push("/about");
      }
    }
  };
</script>
<style>
  #app #hh{
    margin-top: 20px;
  }
</style>
