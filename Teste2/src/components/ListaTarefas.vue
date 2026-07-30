<script setup>
import ItemTarefa from './ItemTarefa.vue'

defineProps({
  tarefas: { type: Array, required: true }
})
defineEmits(['alternar'])
</script>

<template>
  <ul class="lista">
    <ItemTarefa
      v-for="t in tarefas"
      :key="t.id"
      :tarefa="t"
      @click="$emit('alternar', t)"
    />
  </ul>
</template>
