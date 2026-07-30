<script setup>
defineProps({
  tarefa: { type: Object, required: true }
})
</script>

<template>
  <li class="item" :class="{ feita: tarefa.feita }">
    <span class="check">{{ tarefa.feita ? '✓' : '○' }}</span>
    {{ tarefa.nome }}
  </li>
</template>
