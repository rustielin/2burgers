# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import get_object_or_404,render
from django.template import loader
from django.urls import reverse
from django.http import HttpResponse, HttpResponseRedirect, JsonResponse
from .models import Choice,Question


def index(request):
    argument=str(request)
    i=argument.index("=")
    arg=""
    i+=1
    while argument[i]!='\'':
        arg+=argument[i]
        i+=1
    
    
    return JsonResponse({'foo':arg})
def detail(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    return render(request, 'polls/detail.html', {'question': question})

def results(request, question_id):
    question = get_object_or_404(Question, pk=question_id)
    return render(request, 'polls/results.html', {'question': question})
def hello(request):
    return JsonResponse({'foo':'bar'})
def vote(request, question_id):
    return JsonResponse({'foo':'bar'})
#    question = get_object_or_404(Question, pk=question_id)
#    try:
#        selected_choice = question.choice_set.get(pk=request.POST['choice'])
#    except (KeyError, Choice.DoesNotExist):
#        # Redisplay the question voting form.
#        return render(request, 'polls/detail.html', {
#                      'question': question,
#                      'error_message': "You didn't select a choice.",
#                      })
#    else:
#        selected_choice.votes += 1
#        selected_choice.save()
#        # Always return an HttpResponseRedirect after successfully dealing
#        # with POST data. This prevents data from being posted twice if a
#        # user hits the Back button.
#        return JsonResponse({'foo':'bar'})#HttpResponseRedirect(reverse('polls:results', args=(question.id,)))
