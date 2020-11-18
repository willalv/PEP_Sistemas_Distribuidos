<template>
  <v-app>
    <v-main>
      <Formulario/>
    </v-main>
  </v-app>
</template>

<script>
import Formulario from "@/components/Formulario";

export default {
  name: 'App',

  components: {
    Formulario
  },

  data: () => ({
    //
  }),
};
</script>
